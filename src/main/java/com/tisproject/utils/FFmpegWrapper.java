package com.tisproject.utils;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

public class FFmpegWrapper {
	
	public static void incodingVideo(String inputFileName, String path, String afterExtension) throws IOException {
		FFmpeg ffmpeg = new FFmpeg("C:\\tisproject\\tisproject4_1\\src\\main\\resources\\ffmpeg\\bin\\ffmpeg");
		FFprobe ffprobe = new FFprobe("C:\\tisproject\\tisproject4_1\\src\\main\\resources\\ffmpeg\\bin\\ffprobe");
		
		String realInputFilePath = path + inputFileName;
		String beforeExtension = FilenameUtils.getExtension(realInputFilePath);
		String outputFileName = inputFileName.replace("."+beforeExtension, "."+ afterExtension);
		String realOutputFilePath = path + outputFileName;
		
		FFmpegBuilder builder = new FFmpegBuilder()
				.overrideOutputFiles(true)
				.setInput(realInputFilePath)
				.setFormat(afterExtension)
				.addOutput(realOutputFilePath)
				.setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
				.done();
		
		FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
		executor.createJob(builder).run();
	}	
	
	public static int returnWatchTime(String fileURL) throws IOException {
		int returnData = 0;
		
		FFprobe ffprobe = new FFprobe("C:\\tisproject\\tisproject4_1\\src\\main\\resources\\ffmpeg\\bin\\ffprobe");
		
		FFmpegProbeResult probeResult = ffprobe.probe(fileURL); // 동영상 경로
		FFmpegFormat format = probeResult.getFormat();
		double second = format.duration;
		returnData = (int) second;
		
		return returnData;
	}
}
