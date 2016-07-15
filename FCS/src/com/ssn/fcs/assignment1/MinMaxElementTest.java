package com.ssn.fcs.assignment1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class MinMaxElementTest {
	BufferedWriter outputStream;
	MinMaxElement minMaxObj;
	MinMaxNeuron minMaxNeuronObj;
	
	@Test
	public void sortingTechnique() {

		try {
			minMaxObj = new MinMaxElement();
			outputStream = minMaxObj.findMinMaxElement();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException..." + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException..." + e.getMessage());
		}
		if (outputStream != null)
			assertTrue(true);
		else
			assertFalse(false);
	}
	
	@Test
	public void divideAndConquerTechnique() {

		try {
			 minMaxNeuronObj = new MinMaxNeuron();
			outputStream = minMaxNeuronObj.findMinMaxNeuron();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException..." + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException..." + e.getMessage());
		}
		if (outputStream != null)
			assertTrue(true);
		else
			assertFalse(false);
	}

}
