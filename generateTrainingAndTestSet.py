#!/usr/bin/python
# Author : Hasan
import csv
import re
import sys


def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1

def getFeatureList(argv, length):
	features = list();
	for n in range(3, length):
		features.append(int(sys.argv[n]));
	return features;

def generateTestData(reader, iterationNo, splitSize, fileLength, isLast, features):
	start = 0; end = 0;count = 0;
	if(isLast == 1):
		start = splitSize+1; end = fileLength;
	else:
		start = splitSize * (iterationNo - 1) + 1;
		end = start + splitSize -1;
	fileOpen = open("Test-"+str(iterationNo)+".csv","wb");
	for row in reader:
		if(count==0):
			fileOpen.write(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]+","+
			row[5]+","+row[6]+","+row[7]+","+row[8]+","+row[9]+","+row[10]+","+
			row[11]+","+row[12]+","+row[13]+","+row[14]+","+row[15]+","+
			row[16]+","+row[17]+","+row[18]+","+row[19]+","+row[20]+","+
			row[21]+","+row[22]+","+row[23]+","+row[24]+","+row[25]+","+
			row[26]+","+row[27]+"\n");
		if(start<=count):
			for i in range(0,len(features)):
				row[features[i]] = "*";
			fileOpen.write(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]+","+
			row[5]+","+row[6]+","+row[7]+","+row[8]+","+row[9]+","+row[10]+","+
			row[11]+","+row[12]+","+row[13]+","+row[14]+","+row[15]+","+
			row[16]+","+row[17]+","+row[18]+","+row[19]+","+row[20]+","+
			row[21]+","+row[22]+","+row[23]+","+row[24]+","+row[25]+","+
			row[26]+","+row[27]+"\n");
		if(end==count):
			break;
		count = count+1;
	fileOpen.close();

def generateTrainingSet(reader, iterationNo, splitSize, fileLength, isLast):
	start = 0; end = 0;count = 0;
	if(isLast == 1):
		start = splitSize+1; end = fileLength;
	else:
		start = splitSize * (iterationNo - 1) + 1;
		end = start + splitSize -1;
	fileOpen = open("Train-"+str(iterationNo)+".csv","wb");
	# sys.stdout.write(str(start)+" "+str(end)+""+"\n");
	for row in reader:
		if(count==0):
			fileOpen.write(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]+","+
			row[5]+","+row[6]+","+row[7]+","+row[8]+","+row[9]+","+row[10]+","+
			row[11]+","+row[12]+","+row[13]+","+row[14]+","+row[15]+","+
			row[16]+","+row[17]+","+row[18]+","+row[19]+","+row[20]+","+
			row[21]+","+row[22]+","+row[23]+","+row[24]+","+row[25]+","+
			row[26]+","+row[27]+"\n");
		if((count < start and count!=0) or (count > end)):
			fileOpen.write(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]+","+
			row[5]+","+row[6]+","+row[7]+","+row[8]+","+row[9]+","+row[10]+","+
			row[11]+","+row[12]+","+row[13]+","+row[14]+","+row[15]+","+
			row[16]+","+row[17]+","+row[18]+","+row[19]+","+row[20]+","+
			row[21]+","+row[22]+","+row[23]+","+row[24]+","+row[25]+","+
			row[26]+","+row[27]+"\n");
		if(count==fileLength):
			break;
		count = count+1;
	fileOpen.close();



length = len(sys.argv);
fileName = "";
if(length < 3):
	sys.stdout.write("Incorrect Argument\n");
else:
	# This is the fold number
	k = int(sys.argv[1]); 
	fileName = sys.argv[2];
	fileLength = file_len(fileName.strip())-1;
	eachSplitSize = float(fileLength)
	features = list();
	features = getFeatureList(sys.argv, length);
	hasExtra = 0;
	if(fileLength % k == 0):
		eachSplitSize = fileLength/k;
	else:
		hasExtra = 1;
		eachSplitSize = fileLength/k;

	for n in range(0,k):
		with open(fileName, 'rb') as csvfile1:
			reader = csv.reader(csvfile1, delimiter=',')
			generateTestData(reader, n+1, eachSplitSize, fileLength, hasExtra, features);
		with open(fileName, 'rb') as csvfile2:	
			reader1 = csv.reader(csvfile2, delimiter=',')
			generateTrainingSet(reader1, n+1, eachSplitSize, fileLength, hasExtra);
		
	# print length;
	# sys.stdout.write("each split : ");
	# print eachSplitSize;
	# sys.stdout.write("has extra : ");
	# print hasExtra;

sys.stdout.flush();