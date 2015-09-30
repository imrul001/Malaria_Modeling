#!/usr/bin/python
# Author : Hasan
import csv
import re
import sys
import random

# This is the input csv(, delimited)file by command line.
dataFile = sys.argv[1];


# This method replaces the probabilities by a randomely choose value(incidence rates)
def getRandomlyChosenValue(eachEntry):
	r = eachEntry.split(",");
	data = r[0].split(";");
	state = getRandomState(data);
	return str(getTheMidPoint(state));


# This method randomly choose actual incidence rate(0-1) 
# and return the state that the random number is in.
# Here data is a list of probabilities of each entry.
def getRandomState(data):
	randNumber = random.random();
	state = 10;
	bound0 = float(data[0]);
	bound1 = bound0 + float(data[1]);
	bound2 = bound1 + float(data[2]);
	bound3 = bound2 + float(data[3]);
	bound4 = bound3 + float(data[4]);
	# sys.stdout.write("random number = "+str(randNumber)+"\n");
	# sys.stdout.write("bound0 "+str(bound0)+" bound1 "+str(bound1)+" bound2 "+str(bound2)+" bound3 "+str(bound3)+" bound4 "+str(bound4)+"\n");
	if(randNumber > 0 and randNumber <= bound0):
		state = 0;
	if(randNumber > bound0 and randNumber <= bound1):
		state = 1;
	if(randNumber > bound1 and randNumber <= bound2):
		state = 2;
	if(randNumber > bound2 and randNumber <= bound3):
		state = 3;
	if(randNumber > bound3 and randNumber <= bound4):
		state = 4;
	return state;

# This method get the midpoint by each state(0,1,2,3,4)
def getTheMidPoint(state):
	# Predefined Ranges
	# range_s0 = "0-0.0005";
	# range_s1 = "0.0005-0.001339";
	# range_s2 = "0.001339-0.002547";
	# range_s3 = "0.002547-0.005289";
	# range_s4 = "0.005289-0.0673953";
	midPoint = 0.0;
	if(state == 0):
		midPoint = calculateMidpoint(0.0,0.0005);
	if(state == 1):
		midPoint = calculateMidpoint(0.0005,0.001339);
	if(state == 2):
		midPoint = calculateMidpoint(0.001339,0.002547);
	if(state == 3):
		midPoint = calculateMidpoint(0.002547,0.005289);
	if(state == 4):
		midPoint = calculateMidpoint(0.005289,0.0673953);
	return midPoint;	


# This method calculates the mid point between two points
def calculateMidpoint(lowerBound, upperBound):
	return float((lowerBound+upperBound)/2);

# Main Body of the Program
with open(dataFile, 'rb') as csvfile:
    reader = csv.reader(csvfile, delimiter=',')
    i = 0;
    for row in reader:
    	if(i == 0):
    		sys.stdout.write(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]+","+row[5]+"\n");
    	if(i != 0):
    		j = 0;
    		for j in range(0,100):
				sys.stdout.write(getRandomlyChosenValue(row[0])+","+getRandomlyChosenValue(row[1])+","
					+getRandomlyChosenValue(row[2])+","+getRandomlyChosenValue(row[3])+","
					+getRandomlyChosenValue(row[4])+","+row[5]+"\n");	
    	i = i+1;
  		


    		