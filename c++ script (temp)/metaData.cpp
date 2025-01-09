#include <iostream.h>
#include <string.h>
#include <fstream>
using namespace std;

string fileName;
string uploadedBy;
string imageName;
string originalSize;
string dimension;
string flash;
string device;

int main(int argc, char *argv[])
{
    ofstream w;
    ifstream r;

    int size = sizeof(argv) / sizeof(argv[0]);

    for(int i=1;i<size;i++){
        if(i==1) fileName = string(argv[1]);
        if(i==2) uploadedBy = string(argv[2]);
        if(i==3) imageName = string(argv[3]);
        if(i==4) originalSize = string(argv[4]);
        if(i==5) dimension = string(argv[5]);
         if(i==6) flash = string(argv[6]);
         if(i==7) device = string(argv[7]);
    }

    meta_data(w,r);
        
        

    
    
}

void meta_data(ofstream &write, ifstream &read)
{
    ofstream outFile(fileName);
    writeData(write, read);
}

void writeData(ofstream &write, ifstream &read)
{
    write.open(fileName, ios::app);
    write << "Uploaded By:-" << uploadedBy << "\n";
    write << "Image Name:-" << imageName << "\n";
    write << "Original Size:-" << originalSize << "\n";
    write << "Dimension:-" << dimension << "\n";
    write << "Flash:-" << flash << "\n";
    write << "Device:-" << device << "\n";
    write.close();
}

void readData(ifstream &read)
{
    string st;
    read.open(fileName);
  
    while (!read.eof())
    {
        getline(read, st);
        cout << st << endl;
    }
    read.close();
}