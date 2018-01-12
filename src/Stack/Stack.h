#ifndef _STACK_H_
#define _STACK_H_
#include<iostream>
#include<stdexcept>

using namespace std;
/******************************************
  Declaration of Stack Class
******************************************/

template <typename T>
class Stack{
  public:
    Stack();
    ~Stack();
   // Stack(const Stack& stack);

  //Operation stack class supports
  void push(T data);
  void pop();
  inline T peek() { return isEmpty()?throw runtime_error("Stack is empty!"):top->data; };
  unsigned int size();
  void print();
  inline bool isEmpty(){ return top == nullptr; };

  private:
    struct Node;
    Node* top;
    unsigned int stackSize;
    void copy_stack(const Stack& other);

};

//struct Node
template <typename T>
struct
Stack<T>::Node{
  T data;
  Node* next;
  public:
    Node(T value,Node* link):data(value),next(link){};
};

//constructor
template <typename T>
Stack<T>::Stack(){
  top = nullptr;
  stackSize = 0;
}

//destructor
template <typename T>
Stack<T>::~Stack(){
  cout<<"Deleting stack..."<<endl;
  while(!isEmpty()){
    this->pop();
    this->print();
  }
}

template <typename T>
void
Stack<T>::copy_stack(const Stack& other){

  Node* ptr, * newNode, * last = nullptr;
  for (ptr = other.top; ptr != nullptr; ptr = ptr->next){
     newNode = new Node(ptr->data,nullptr);
     if (last == nullptr)
        top = newNode;
     else
        last->next = newNode;
     last = newNode;
   }
}

//copy constructor
template <typename T>
Stack<T>::Stack(const Stack& other){
  cout<<"Copying stack..."<<endl;
  top = nullptr;
  copy_stack(other);
}


template <typename T>
void
Stack<T>::push(T data){
  stackSize++;
  Node* new_node = new Node(data,top);
  top = new_node;
}

template <typename T>
void
Stack<T>::pop(){
  Node* temp = top; //node to delete
  top = top->next;
  stackSize--;
  delete temp;
}


template <typename T>
void
Stack<T>::print(){

  if(isEmpty()){
    cout<<"[ ]"<<endl;
    return ;
  }
  cout<<"[";
  Node* temp  = top;
  while(temp->next!=nullptr){
    cout<<temp->data<<",";
    temp = temp->next;
  }
  cout<<temp->data<<"]"<<endl;
}

template <typename T>
unsigned int
Stack<T>::size(){
  return stackSize;
}


#endif //end of stack
