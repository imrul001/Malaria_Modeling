#!/usr/bin/python
# Author : Hasan
import csv
import re
import random
import sys


#                      Estimate Std. Error z value Pr(>|z|)    
# (Intercept)         -2.593352   0.005040 -514.55   <2e-16 ***
# M_NDVI_w1            0.186465   0.001869   99.75   <2e-16 ***
# M_Dist_to_Border_w1  0.077873   0.002338   33.30   <2e-16 ***
# M_Dist_to_Stream_w1  0.213831   0.001851  115.55   <2e-16 ***
# M_Slope_Rainfall_w1  0.186333   0.001852  100.59   <2e-16 ***
# M_Stream_Density_w1  0.191685   0.001867  102.70   <2e-16 ***


def getMinPoint(state):
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

def getCoEfficient(variable):
	coefficient = ['0.186333', '0.077873', '0.186465', '0.213831', '0.191685'];
	variable_name = ['M_Slope_Rainfall_w1','M_Dist_to_Border_w1','M_NDVI_w1','M_Dist_to_Stream_w1','M_Stream_Density_w1'];
	if(variable == variable_name[0]):
		return coefficient[0];
	if(variable == variable_name[1]):
		return coefficient[1];
	if(variable == variable_name[2]):
		return coefficient[2];
	if(variable == variable_name[3]):
		return coefficient[3];
	if(variable == variable_name[4]):
		return coefficient[4];
	return returnCoeff;

def printEachCondition(row):
	variable_name = ['M_Slope_Rainfall_w1','M_Dist_to_Border_w1','M_NDVI_w1','M_Dist_to_Stream_w1','M_Stream_Density_w1'];
	state_name =['s0', 's1', 's2', 's3', 's4'];
	pair_num = '1';
	parcentage = '1.0';
	midpoint = ['0.025','0.0912','0.1943', '0.3918', '3.6544'];
	coefficient = ['0.186333', '0.077873', '0.186465', '0.213831', '0.191685'];
	intercept = '-2.593352';	
	i = 0;
	for i in range(0,5):
		if(i == 0):
			condition = variable_name[i]+" == "+row[i]+" && ";
			decision =  "mult(exp("+getMinPoint(row[i])+"*"+getCoEfficient(variable_name[i])+"+("+intercept+")),";
		if(i > 0 and i <4):
			condition = condition + variable_name[i]+" == "+row[i]+" && ";
			decision =  decision+"exp("+getMinPoint(row[i])+"*"+getCoEfficient(variable_name[i])+"),";
		if(i == 4):
			condition = condition + variable_name[i]+" == "+row[i]+", ";
			decision =  decision+"exp("+getMinPoint(row[i])+"*"+getCoEfficient(variable_name[i])+")),";
	return condition +	pair_num+", "+parcentage+","+decision+"\n";	

# Format of each condition
# variable_name == state_name,  pair_num,  parcentage,midpoint*co-efficient, intercept;

combinaition_file = sys.argv[1];
with open(combinaition_file, 'rb') as csvfile:
    reader = csv.reader(csvfile, delimiter=',')
    i = 0;
    for row in reader:
    	sys.stdout.write(printEachCondition(row));

# M_Slope_Rainfall_w1==s0,  1,  1.0,0.025*0.186333+(-2.593352),
# M_Slope_Rainfall_w1==s1,  1,  1.0,0.0912*0.186333+(-2.593352),
# M_Slope_Rainfall_w1==s2,  1,  1.0,0.1943*0.186333+(-2.593352),
# M_Slope_Rainfall_w1==s3,  1,  1.0,0.3918*0.186333+(-2.593352),
# M_Slope_Rainfall_w1==s4,  1,  1.0,3.6544*0.186333+(-2.593352),

# M_Dist_to_Border_w1==s0,  1,  1.0, 0.025*0.077873,
# M_Dist_to_Border_w1==s1,  1,  1.0, 0.0912*0.077873,
# M_Dist_to_Border_w1==s2,  1,  1.0,0.1943*0.077873,
# M_Dist_to_Border_w1==s3,  1,  1.0,0.3918*0.077873,
# M_Dist_to_Border_w1==s4,  1,  1.0,3.6544*0.077873,

# M_NDVI_w1==s0,  1,  1.0,0.025*0.186465,
# M_NDVI_w1==s1,  1,  1.0,0.0912*0.186465,
# M_NDVI_w1==s2,  1,  1.0,0.1943*0.186465,
# M_NDVI_w1==s3,  1,  1.0,0.3918*0.186465,
# M_NDVI_w1==s4,  1,  1.0,3.6544*0.186465,

# M_Dist_to_Stream_w1==s0,  1,  1.0,0.025*0.213831,
# M_Dist_to_Stream_w1==s1,  1,  1.0,0.0912*0.213831,
# M_Dist_to_Stream_w1==s2,  1,  1.0,0.1943*0.213831,
# M_Dist_to_Stream_w1==s3,  1,  1.0,0.3918*0.213831,
# M_Dist_to_Stream_w1==s4,  1,  1.0,3.6544*0.213831,

# M_Stream_Density_w1==s0,  1,  1.0,0.025*0.191685,
# M_Stream_Density_w1==s1,  1,  1.0,0.0912*0.191685,
# M_Stream_Density_w1==s2,  1,  1.0,0.1943*0.191685,
# M_Stream_Density_w1==s3,  1,  1.0,0.3918*0.191685,
# M_Stream_Density_w1==s4,  1,  1.0,3.6544*0.191685)


sys.stdout.write("Imrul is a bad body");


sys.stdout.flush();