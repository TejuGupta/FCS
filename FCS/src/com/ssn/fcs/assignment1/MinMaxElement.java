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
import java.util.Arrays;

public class MinMaxElement {
	BufferedWriter outputStream;

	BufferedWriter findMinMaxElement() throws FileNotFoundException, IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File ipFile = new File(classLoader.getResource("temperatureUnits.txt").getFile());
		BufferedReader inputStream;
		
		File opFile = File.createTempFile("minmaxOutput", ".txt");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(opFile)));
		Datum[] datumArray = null;
		int i = 0;
		String aux = "";
		
		Long min, max; min = 0L; max = 0L;
		 
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
			System.out.println("Neurons.."+neurons);
			Datum datum = new Datum();
			datum.setSensorID(Long.parseLong(neurons[0]));
			datum.setLocation(neurons[1]);
			datum.setTimeStamp(Timestamp.valueOf(neurons[2]));
			datum.setTemperatureValue(Long.parseLong(neurons[3]));
			datum.setTemperatureUnit(Long.parseLong(neurons[4]));
			
			datumArray[i] = datum;
			i++;
		}
		System.out.println("DatumArray.."+datumArray[0]);
		Arrays.sort(datumArray, Datum.DatumComparator);
		inputStream.close();
		/*for(int l=0;l<datumArray.length;l++){
			
			while (datumArray.length > 0) {
				int k, j;
				k = 0;
				j = 0;
				long tempmin, tempmax;
				tempmin = 0L;
				tempmax = 0L;
				if ((datumArray.length % 2 == 0) && (isInteger((datumArray.length - 2) / 4))) {
					if (datumArray.length > 2) {

					} else {
						
						(datumArray[k],datumArray[j]);
						long l1 = Long.parseLong(datumArray[k]);
						long l2 = Long.parseLong(datumArray[j]);
						if (l1 > l2) {
							tempmin = l2;
							tempmax = l1;
						}
					}
				} else { // odd number of units Math.ceil(neurons.length);
					Math.floor(neurons.length);
				}
			}
		}*/

		
	
		writer.write(datumArray[0].toString());
		writer.write(datumArray[cnt-1].toString());
		System.out.println("OutputBuffer.."+writer+" Values:"+datumArray[0].toString()+"...."+datumArray[cnt-1].toString());
		return writer;

	}

/*	private boolean isInteger(int i) {
		// TODO Auto-generated method stub
		if (i % 1 == 0)
			return true;
		return false;
	}*/
}
