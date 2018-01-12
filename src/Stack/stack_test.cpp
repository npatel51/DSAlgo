#include<iostream>
#include "Stack.h"
using namespace std;

int main( void ){

  Stack<int> s;

  s.push(2015);
  s.push(2016);
  s.push(2017);
  s.push(2018);

  s.print();

  cout<<"Size of stack: "<<s.size()<<endl;
  cout<<"First item on stack: "<<s.peek()<<endl;


  while(!s.isEmpty()){
    s.pop();
    s.print();
  }


  return 0;
}
