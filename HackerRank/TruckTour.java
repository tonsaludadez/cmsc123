#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
 
int main() {
    int totalPetrolPumps = 0;
    vector<int> petrolQuantities, distances;
    cin>>totalPetrolPumps;
    int petrol = 0, km = 0;
    for (int index = 0; index < totalPetrolPumps; index++){
        cin >> petrol;
        cin>>km;
        petrolQuantities.push_back(petrol);
        distances.push_back(km);
    }
 
    int startIndex = 0, endIndex = totalPetrolPumps - 1;
    int needToCoverKm = 0;
    int remainPetrol = 0;
    int sortestIndex = 0;
    while (startIndex != endIndex){
        if (startIndex == totalPetrolPumps){
            startIndex = 0;
        }
 
        remainPetrol = petrolQuantities[startIndex] - distances[startIndex];
        if ((needToCoverKm <= 0) && (remainPetrol >= 0)){
            sortestIndex = startIndex;
            endIndex = startIndex;
            needToCoverKm = 0;
        }
 
        needToCoverKm += remainPetrol;
        startIndex++;
    }
 
    printf("%d", sortestIndex);
    return 0;
}