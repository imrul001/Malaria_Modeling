#!/usr/bin/python
# Author : Hasan

# This script is for random sampling of probabilities of causal nodes(M_ nodes)
import csv
import sys
import random

# This method will convert the probability range from 0-1 to 0-100
# I guess I don't need that(Currently Now used in this script)
def getDataInPercentageRange(r):
	r = r.split(",")
	data = r[0].split(";");
	for i in range(0,len(data)):
		if(i==0):
			result = float(data[i])*100;
		if(i>0):
			result = str(result)+";"+str(float(data[i])*100);
	return result;

# This method will select a sample(out of 5 Randomly)
def selectRandomSample(part_of_row_by_column):
	randomIndex = random.randint(0,4);
	r = part_of_row_by_column.split(",");
	data = r[0].split(";");
	return data[randomIndex];

# Input the data file of csv(, delimited) format
dataFile = sys.argv[1];

with open(dataFile, 'rb') as csvfile:
    reader = csv.reader(csvfile, delimiter=',')
    i = 0;
    for row in reader:
    	if(i == 0):
    		sys.stdout.write(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]+","+row[5]+"\n");
    	if(i != 0):
    		sys.stdout.write(selectRandomSample(row[0])+","+selectRandomSample(row[1])+","+selectRandomSample(row[2])+
    			","+selectRandomSample(row[3])+","+selectRandomSample(row[4])+","+row[5]+"\n");
    	i = i+1;
    	sys.stdout.flush();


