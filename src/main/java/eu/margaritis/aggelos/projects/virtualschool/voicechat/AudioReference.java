package eu.margaritis.aggelos.projects.virtualschool.voicechat;

import javax.sound.sampled.AudioFormat;

/**
 * This class contains some methods and variables mandatory for the voice chat to
 * work.
 * 
 * @author Aggelos
 */
public final class AudioReference {
	
	private static final float SAMPLE_RATE = 8000.0F;
	private static final int SAMPLE_SIZE = 8;
	private static final int CHANNEL_AMOUNT = 1;
	private static final boolean SIGNED = true;
	private static final boolean BIG_ENDIAN = false;
		
	public static float getSampleRate() {
		return SAMPLE_RATE;
	}
	
	public static int getSampleSize() {
		return SAMPLE_SIZE;
	}
	
	public static int getChannelAmount() {
		return CHANNEL_AMOUNT;
	}
	
	public static boolean isSingned() {
		return SIGNED;
	}
	
	public static boolean isBigEndian() {
		return BIG_ENDIAN;
	}
	
	public static AudioFormat getReferenceAsFormat() {
		return new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, CHANNEL_AMOUNT, SIGNED, BIG_ENDIAN);
	}
	
}
