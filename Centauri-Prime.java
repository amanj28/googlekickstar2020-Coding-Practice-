#include<bits/stdc++.h>
using namespace std;
#define ins     insert

void solve() {
    string ss;
    cin >> ss;
    cout << ss;
    set<char> s;
    s.ins('a');
    s.ins('e');
    s.ins('i');
    s.ins('o');
    s.ins('u');
    s.ins('A');
    s.ins('E');
    s.ins('I');
    s.ins('O');
    s.ins('U');
    int n = ss.size() - 1;
    if(n == -1){
        cout << ss << " is ruled by nobody." << endl;
    	return;
    }
    if(ss[n] == 'y' || ss[n] == 'Y'){
    	cout << " is ruled by nobody." << endl;
    	return;
    }
    if(s.find(ss[n]) != s.end()) cout << " is ruled by Alice.";
    else cout << " is ruled by Bob.";
    cout << endl;
}

 
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    
    int x = 1, t; 
    cin >> t;
	while(t--){
		cout << "Case #" << x++ <<": ";
		solve();
	}
	return 0;
}
