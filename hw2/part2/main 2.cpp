#include <iostream>
#include <cassert>
#include <cstdlib>

//------------------------------------------------------------------------
// Class Declaration
//------------------------------------------------------------------------

class BinaryTreeInt
{
 public:

  struct Node
  {
    Node( int v );
    int   value;
    Node* left_p;
    Node* right_p;
  };

  BinaryTreeInt();
  ~BinaryTreeInt();
  void insert_root( int v );
  void insert_left( Node* node_p, int v );
  void insert_right( Node* node_p, int v );

  bool contains( int v ) const;
  void add( int v );

  void print() const;

  Node* m_root_p;

 private:

  void clear_h( Node* node_p );
  void print_h( Node* node_p, int level ) const;
  Node* find_h( Node* node_p, int v ) const;

};

//------------------------------------------------------------------------
// Class Definition
//------------------------------------------------------------------------

BinaryTreeInt::Node::Node( int v )
  : value(v), left_p(nullptr), right_p(nullptr)
{ }

BinaryTreeInt::BinaryTreeInt()
  : m_root_p(nullptr)
{ }

BinaryTreeInt::~BinaryTreeInt()
{
  clear_h( m_root_p );
}

void BinaryTreeInt::insert_root( int v )
{
  m_root_p = new Node(v);
}

void BinaryTreeInt::insert_left( Node* node_p, int v )
{
  node_p->left_p = new Node(v);
}

void BinaryTreeInt::insert_right( Node* node_p, int v )
{
  node_p->right_p = new Node(v);
}

void BinaryTreeInt::print() const
{
  print_h( m_root_p, 0 );
}

// this is inorder traversal
void BinaryTreeInt::print_h( Node* node_p, int level ) const
{

  if ( node_p->right_p != nullptr )
    print_h( node_p->right_p, level+1 );

  for ( int i = 0; i < level; i++ )
    std::cout << "  ";
  std::cout << node_p->value << std::endl;
  
  if ( node_p->left_p != nullptr )
    print_h( node_p->left_p, level+1 );

  
}

// this is post-order traversal
void BinaryTreeInt::clear_h( Node* node_p )
{
  if ( node_p->left_p != nullptr )
    clear_h( node_p->left_p );
  if ( node_p->right_p != nullptr )
    clear_h( node_p->right_p );
  delete node_p;
}

bool BinaryTreeInt::contains( int v ) const
{
  if ( m_root_p == nullptr )
    return false;

  Node* node_p = find_h( m_root_p, v );
  return ( node_p->value == v );
}

void BinaryTreeInt::add( int v )
{
  if ( m_root_p == nullptr )
    insert_root( v );

  Node* node_p = find_h( m_root_p, v );
  if ( node_p->value != v ) {
    if ( v > node_p->value )
      insert_right( node_p, v );
    else
      insert_left( node_p, v );
  }
}

BinaryTreeInt::Node* BinaryTreeInt::find_h( Node* node_p, int v ) const
{
  assert( node_p != nullptr );

  if ( v == node_p->value )
    return node_p;

  if ( v > node_p->value ) {
    if ( node_p->right_p == nullptr )
      return node_p;
    else
      return find_h( node_p->right_p, v );
  }

  if ( v < node_p->value ) {
    if ( node_p->left_p == nullptr )
      return node_p;
    else
      return find_h( node_p->left_p, v );
  }

  assert( false );
}

//------------------------------------------------------------------------
// main
//------------------------------------------------------------------------

int main( void )
{
  using namespace std;

  BinaryTreeInt bt;
  for ( int v : { 55, 20, 74, 5, 43, 59, 99, 12, 32 } )
    bt.add( v );

  std::cout << "Initial tree" << std::endl;
  bt.print();

  bt.add( 35 );

  std::cout << "Tree after inserting 35" << std::endl;
  bt.print();

  //bt.find_h(3, 32)

  return 0;
}

