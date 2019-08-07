#include <iostream>

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

  void print() const;

  Node* m_root_p;

 private:

  void clear_h( Node* node_p );
  void print_h( Node* node_p, int level ) const;

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

void BinaryTreeInt::clear_h( Node* node_p )
{
  if ( node_p->left_p != nullptr )
    clear_h( node_p->left_p );
  if ( node_p->right_p != nullptr )
    clear_h( node_p->right_p );
  delete node_p;
}

//------------------------------------------------------------------------
// main
//------------------------------------------------------------------------

int main( void )
{
  BinaryTreeInt bt;
  bt.insert_root( 10 );

  typedef BinaryTreeInt::Node Node;
  Node* r = bt.m_root_p;

  bt.insert_left ( r, 11 );
  bt.insert_right( r, 12 );

  bt.insert_left ( r->left_p,  13 );
  bt.insert_right( r->left_p,  14 );

  bt.insert_left ( r->right_p, 15 );
  bt.insert_right( r->right_p, 16 );

  bt.insert_left ( r->left_p->left_p, 15 );
  bt.insert_right( r->left_p->left_p, 16 );

  bt.print();
  return 0;
}

