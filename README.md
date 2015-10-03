# Script for generating Training and Test Cases for Malaria Modeling
This script generates a complete set of Training and Test cases. Number of data splits and Data Features are customizable.    

Usage:
=====

python generateTrainingAndTestSet.py [Number_of_splits] [CSV_File_Name] [feature_0, feature_1, feature_2....feature_3]

Here 
          (1) generateTrainingAndTestSet.py is the name of the script. 
          (2) [Number_of_splits] is the number of the splits of file(In our case 10). 
          (3) [CSV_File_Name] is the csv file that contains all the model Dataset. 
          (4) [feature_0..feature_1] are the serial numbers of the columns of the csv file you want to generate Test                   cases with(All this columns will be replaced by "*"). 

Example:
=======
Command: python generateTrainingAndTestSet.py 10 model_dataSet-causal-indep_updated.csv 10 11 12 14 15 16 17 18 20 21 22 24 25 26 27 28 30 31 32 34 35 36 37 38

It will generate 10 case files in pairs(like (Train-1,Test-1),(Train-2,Test-2) and so on) in the current directory. The resulting Training and Test cases of the above command are saved in the Training-Test-Set/ directory of this repository. 





