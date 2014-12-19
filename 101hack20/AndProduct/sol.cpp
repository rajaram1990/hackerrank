#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <limits>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int T;
    cin>>T;
    unsigned int a[T];
    unsigned int b[T];
    unsigned int ans[T];
    unsigned temp_int;
    for (int i=0;i<T;i++)
    {
        cin>>a[i]>>b[i];
        temp_int = std::numeric_limits<unsigned int>::max();
            // Find 2 power of b
            // set a as that and temp_int as 2^that
            // Iterate from there
            int power_of_b = 0;
            int j;
            while (b[i]>(pow(2,power_of_b)))
            {
                power_of_b++;
            }
            power_of_b--;
//            cout<<"power of b"<<power_of_b;
            if (a[i]>pow(2,power_of_b))
            {
                j = a[i];
            }
            else
            {
//                cout<<"there is a power of 2 between a[i] and b[i]"<<endl;
                j = pow(2,power_of_b);
                temp_int = pow(2,power_of_b);
            }
            for(;j<b[i];j++)
            {
                temp_int = temp_int & j;
                if (temp_int ==0)
                    break;
            }
        ans[i] = temp_int;
    }
    for(int i=0;i<T;i++)
    {
        cout<<ans[i]<<endl;
    }
    return 0;
}
