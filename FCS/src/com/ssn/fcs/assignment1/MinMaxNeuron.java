package com.ssn.fcs.assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;

public class MinMaxNeuron {
	BufferedWriter outputStream;

	BufferedWriter findMinMaxNeuron() throws FileNotFoundException, IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File ipFile = new File(classLoader.getResource("temperatureUnits.txt").getFile());
		BufferedReader inputStream;

		File opFile = File.createTempFile("minmaxOutput", ".txt");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(opFile)));
		Datum[] datumArray = null;
		int i = 0;
		String aux = "";

		LineNumberReader reader = new LineNumberReader(new FileReader(ipFile));
		int cnt = 0;
		while ((reader.readLine()) != null) {
		}

		cnt = reader.getLineNumber();
		datumArray = new Datum[cnt];
		reader.close();
		inputStream = new BufferedReader(new FileReader(ipFile));
		while ((aux = inputStream.readLine()) != null) {
			String neurons[] = aux.split(",");
			System.out.println("Neurons.." + neurons);
			Datum datum = new Datum();
			datum.setSensorID(Long.parseLong(neurons[0]));
			datum.setLocation(neurons[1]);
			datum.setTimeStamp(Timestamp.valueOf(neurons[2]));
			datum.setTemperatureValue(Long.parseLong(neurons[3]));
			datum.setTemperatureUnit(Long.parseLong(neurons[4]));

			datumArray[i] = datum;
			i++;
		}
		inputStream.close();
		Datum[] finalDatum = divideAndConquer(datumArray, 0);
		writer.write(finalDatum[0].toString());
		writer.write(finalDatum[cnt - 1].toString());
		return writer;

	}

	Datum[] divideAndConquer(Datum[] datumArray, int pointer) {
		int length = datumArray.length;
		int flag = 0;
		if (pointer > length && length % 2 != 0) {
			if (datumArray[pointer].compareTo(datumArray[pointer - 1]) > 0) {
				Datum tempDatum = new Datum(datumArray[pointer]);
				datumArray[pointer] = datumArray[pointer - 1];
				datumArray[pointer - 1] = tempDatum;

			}

			if (datumArray[pointer].compareTo(datumArray[pointer - 2]) < 0) {
				Datum tempDatum = new Datum(datumArray[pointer]);
				datumArray[pointer] = datumArray[pointer - 2];
				datumArray[pointer - 2] = tempDatum;

			}
			flag = 1;
		}

		else if (pointer > length && length % 2 == 0) {
			flag = 1;
		}
		if (datumArray[pointer].compareTo(datumArray[pointer + 1]) < 0 && datumArray != null) {
			Datum tempDatum = new Datum(datumArray[pointer]);
			datumArray[pointer] = datumArray[pointer + 1];
			datumArray[pointer + 1] = tempDatum;

		}

		if (pointer != 0) {
			if (datumArray[pointer - 3].compareTo(datumArray[pointer - 1]) < 0) {
				Datum tempDatum = new Datum(datumArray[pointer - 3]);
				datumArray[pointer - 3] = datumArray[pointer - 1];
				datumArray[pointer - 1] = tempDatum;

			}

			if (datumArray[pointer - 2].compareTo(datumArray[pointer]) > 0) {
				Datum tempDatum = new Datum(datumArray[pointer - 2]);
				datumArray[pointer - 2] = datumArray[pointer];
				datumArray[pointer] = tempDatum;

			}
		}
		if (flag != 1) {
			for (int i = pointer; i < length; i += 2) {
				datumArray = divideAndConquer(datumArray, i);
			}
		}

		return datumArray;
	}

	void swap(Datum first, Datum second) {
		if (first != null && second != null) {
			Datum tempDatum = new Datum(first);
			first = second;
			second = tempDatum;
		}
	}

}
