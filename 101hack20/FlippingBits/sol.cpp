# include <iostream>
#include <limits>
using namespace std;
int main()
{
    int T;
    cin>>T;
    unsigned int elems[T];
    unsigned int ans[T];
    unsigned int max_unsigned_int_size = std::numeric_limits<unsigned int>::max();
    for (int i=0;i<T;i++)
    {
        cin>>elems[i];
        ans[i] = elems[i]^max_unsigned_int_size;
    }
    for(int i=0;i<T;i++)
    {
        cout<<ans[i]<<endl;
    }
    return 0;
}
