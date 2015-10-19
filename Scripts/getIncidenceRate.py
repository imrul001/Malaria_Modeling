#!/usr/bin/python
# Author : Hasan
import csv
import re
import sys

def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1;

def getRowDynamically(row):
	total = "";
	num_cols = len(row);
	for i in range(0,num_cols):
		if(i == 0):
			total = row[i]+",";
		if(i > 0 and i < (num_cols -1)):
			total = total +row[i]+",";
		if(i == (num_cols -1)):
			total = total +row[i]+"\n";	
	return total;

dataFile = sys.argv[1];
populationFile = sys.argv[2];

length=file_len(populationFile);
village=range(length);
pop12=range(length);
pop13=range(length);
pop14=range(length);

i=0;
with open(populationFile, 'rb') as csvfile:
    reader = csv.reader(csvfile, delimiter=',')
    for row in reader:
    	if(i != 0):
	    	village[i]=(row[7]);
	        pop12[i]=(row[12]);
	        pop13[i]=(row[13]);
	        pop14[i]=(row[14]);
        i=i+1;
m =0;
for j in range(0,length):
	with open(dataFile, 'rb') as csvfile2:	
		reader1 = csv.reader(csvfile2, delimiter=',')
		c = 0;
		for row in reader1:
			if(c!=0):
				inc_rate_w0 = float(row[11]);
				inc_rate_w1 = float(row[19]);
				inc_rate_w2 = float(row[26]);
				inc_rate_w3 = float(row[33]);
				flag = 0;
				if (village[j] == row[3] and row[0]==str(2012)):
					inc_rate_w0 = float(row[11])/float(pop12[j]);
					inc_rate_w1 = float(row[19])/float(pop12[j]);
					inc_rate_w2 = float(row[26])/float(pop12[j]);
					inc_rate_w3 = float(row[33])/float(pop12[j]);
					flag = 1;
				if (village[j] == row[3] and row[0]==str(2013)):
					inc_rate_w0 = float(row[11])/float(pop13[j]);
					inc_rate_w1 = float(row[19])/float(pop13[j]);
					inc_rate_w2 = float(row[26])/float(pop13[j]);
					inc_rate_w3 = float(row[33])/float(pop13[j]);
					flag = 1;
				if (village[j] == row[3] and row[0]==str(2014)):
					inc_rate_w0 = float(row[11])/float(pop14[j]);
					inc_rate_w1 = float(row[19])/float(pop14[j]);
					inc_rate_w2 = float(row[26])/float(pop14[j]);
					inc_rate_w3 = float(row[33])/float(pop14[j]);
					flag = 1;
				row[11] = str(inc_rate_w0);
				row[19] = str(inc_rate_w1);
				row[26] = str(inc_rate_w2);
				row[33] = str(inc_rate_w3);
				if(flag == 1):
					sys.stdout.write(getRowDynamically(row));
			if(c==0 and m==0):
				sys.stdout.write(getRowDynamically(row));
				m=1;
			c = c + 1;





