#!/usr/bin/python
# Author : Hasan
import csv
import re
import sys
import random
import math


def getFuntionValue(NDVI, DIST_TO_BORDER, DIST_TO_STREAM, SLOPE_RAINFALL, STREAM_DENSITY):
	result = (-2.593352)+ NDVI*(0.186465)+ DIST_TO_BORDER*(0.077873)+DIST_TO_STREAM*(0.213831)+SLOPE_RAINFALL*(0.186333)+STREAM_DENSITY*(0.191685);
	return math.exp(result);

def getMidPoint(state):
	if (state == "s0"):
		return '0.025';
	if (state == "s1"):
		return '0.0912'
	if (state == "s2"):
		return '0.1943';
	if (state == "s3"):
		return '0.3918';
	if (state == "s4"):
		return '3.6544';

def getState(value):
	value = float(value);
	if(value > 0 and value <=0.05):
		return "s0";
	if(value > 0.05 and value <=0.1339):
		return "s1";
	if(value > 0.1339 and value <=0.2547):
		return "s2";
	if(value > 0.2547 and value <=0.5289):
		return "s3";
	if(value > 0.5289 and value <=6.73953):
		return "s4";

def getProbabilities(eachCombinition):
	states = eachCombinition.split(",");
	NDVI = float(getMidPoint(states[0]));
	DIST_TO_BORDER = float(getMidPoint(states[1]));
	DIST_TO_STREAM = float(getMidPoint(states[2]));
	SLOPE_RAINFALL = float(getMidPoint(states[3]));
	STREAM_DENSITY = float(getMidPoint(states[4]));
	result = getFuntionValue(NDVI, DIST_TO_BORDER, DIST_TO_STREAM, SLOPE_RAINFALL, STREAM_DENSITY);
	return str(result);

def printEachEntry(resultProbability):
	state = getState(resultProbability);
	if(state == "s0"):
		return "1, 0, 0, 0, 0"
	if(state == "s1"):
		return "0, 1, 0, 0, 0"
	if(state == "s2"):
		return "0, 0, 1, 0, 0"
	if(state == "s3"):
		return "0, 0, 0, 1, 0"
	if(state == "s4"):
		return "0, 0, 0, 0, 1"

comboFile = sys.argv[1];

with open(comboFile, 'rb') as csvfile:
	reader = csv.reader(csvfile, delimiter='\t')
	i = 0;
	for row in reader:
		# sys.stdout.write(row[0]+" === "+printEachEntry(getProbabilities(row[0]))+"\n");
		sys.stdout.write(printEachEntry(getProbabilities(row[0]))+"\n") 
