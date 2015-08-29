# Script for generating Training and Test Cases for Malaria Modeling

Usage:
=====

python generateTrainingAndTestSet.py [Number_of_splits] [CSV_File_Name] [feature_0, feature_1, feature_2....feature_3]

Here (1) generateTrainingAndTestSet.py is the name of the script.
     (2) [Number_of_splits] is the number of the splits of file(In our case 10).
     (3) [CSV_File_Name] is the csv file that contains all the model Dataset.
     (4) [feature_0..features_1] are the serial numbers of the columns of the csv file you want to generate Test cases 
     with.

Example:
=======
python generateTrainingAndTestSet.py 10 model_dataSet_ex-3.csv 8 9 12 14 15 18 20 21 24

The resulting Training and Test cases of the above command are saved in the Training-Test-Set/ directory of this 
repository..





