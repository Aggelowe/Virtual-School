package eu.margaritis.aggelos.projects.virtualschool.chat;

import java.io.ByteArrayOutputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.util.TickingThread;

@SideOnly(Side.CLIENT)
public final class VoiceReplyThread extends TickingThread {

	private TargetDataLine microphone;
	private SourceDataLine speakers;
	private ByteArrayOutputStream output;
	private int intBytesRead;
	private final int chunkSize = 1024;
	private byte[] data;

	@Override
	public void init() throws LineUnavailableException {
		Info info = new Info(TargetDataLine.class, getAudioFormat());
		microphone = (TargetDataLine) AudioSystem.getLine(info);
		microphone.open(getAudioFormat());
		output = new ByteArrayOutputStream();
		data = new byte[microphone.getBufferSize() / 5];
		microphone.start();
		Info dataLineInfo = new Info(SourceDataLine.class, getAudioFormat());
		speakers = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
		speakers.open(getAudioFormat());
		speakers.start();
	}

	@Override
	public void tick() {
		intBytesRead = microphone.read(data, 0, chunkSize);
		output.write(data, 0, intBytesRead);
		speakers.write(data, 0, intBytesRead);
	}

	@Override
	public void end() {
		speakers.drain();
		speakers.close();
		microphone.close();
	}

	private AudioFormat getAudioFormat() {
		float sampleRate = Reference.VoiceChatReference.getSampleRate();
		int sampleSize = Reference.VoiceChatReference.getSampleSize();
		int channels = Reference.VoiceChatReference.getChannels();
		boolean signed = Reference.VoiceChatReference.isSigned();
		boolean bigEndian = Reference.VoiceChatReference.isBigEndian();
		return new AudioFormat(sampleRate, sampleSize, channels, signed, bigEndian);
	}

}