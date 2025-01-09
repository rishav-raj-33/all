#include <iostream.h>
#include <string.h>
#include <fstream>
using namespace std;

string fileName;
string imageName;
string originalSize;
string dimension;
string imgeType;
string fileModifiedDate;
string newPath = "D:\\Learning space\\Projects\\Glow\\Resources-temp\\Back-end (temp)\\Glow-temp\\meta-data\\";

void writeData(ofstream &write, ifstream &read)
{

    write.open(newPath + fileName, ios::app);
    write << "Image Name:-" << imageName << "\n";
    write << "Original Size:-" << originalSize << "\n";
    write << "Dimension:-" << dimension << "\n";
    write << "Image Tpye:-" << imgeType << "\n";
    write << "File Modified Date:-" << fileModifiedDate << "\n";
    write.close();
}

void meta_data(ofstream &write, ifstream &read)
{
    ofstream outFile(newPath + fileName);
    writeData(write, read);
}

int main(int argc, char *argv[])
{
    ofstream w;
    ifstream r;

    for (int i = 1; i < 7; i++)
    {
        if (i == 1)
            fileName = string(argv[1]);

        if (i == 2)
            imageName = string(argv[2]);
        if (i == 3)
            originalSize = string(argv[3]);
        if (i == 4)
            dimension = string(argv[4]);
        if (i == 5)
            imgeType = string(argv[5]);
        if (i == 6)
            fileModifiedDate = string(argv[6]);
    }

    meta_data(w, r);
    cout << "Successful";
}
