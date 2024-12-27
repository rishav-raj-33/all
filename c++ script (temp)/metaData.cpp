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

int main()
{
    ofstream w;
    ifstream r;
}

void meta_data(ofstream &write, ifstream &read)
{
    ofstream outFile(fileName);
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