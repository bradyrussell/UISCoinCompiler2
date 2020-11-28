grammar UISC;

file:   (functionDeclaration | varDeclaration | statement)+ ;

pointer
    : '@';

varDeclaration
    :   constant='const'? type pointer? ID ('=' expression)? ';' #varInitialization    // int32@ myPtr = 7; //read as: there is an int32 at (address) 7
    |   type pointer? ID '[' size=INT ']' ('=' expression)? ';' #arrayAssignmentInitialization  // todo const arrays?
    |   type ID '[]' '=' arrayInitializer ';' #arrayValueInitialization
    ;
type:   'void' | 'byte' | 'int32' | 'int64' | 'float' ;//| ID ; //this allows user-defined types

booleanLiteral: 'true' | 'false';

arrayInitializer
    : '{' exprList? '}'
    ;

functionDeclaration
    :   type ID '(' formalParameters? ')' block // "void f(int x) {...}"
    ;
formalParameters
    :   formalParameter (',' formalParameter)*
    ;
formalParameter
    :   type pointer? ID
    ;

block:  '{' statement* '}' ;   // possibly empty statement block

statement:   block                      #blockStatement
    |   varDeclaration                  #varDeclarationStatement
    |   'if' conditional=expression '{' ifbody=statement '}' elseifStatement* elseStatement? #ifStatement
    |   'fori' '(' iterations=INT 'as' type ID ')' forbody=statement                       #foriStatement
    |   'foreach' '(' arrayToLoop=ID 'as' varDeclaration ')' forbody=statement     #foreachStatement
    |   'return' retval=expression? ';'        #returnStatement
    |   lhs=ID ('[' arrayIndex=expression ']')? '=' rhs=expression ';'      #assignmentStatement
    |   lhs=ID ('[' arrayIndex=expression ']')? op=('+='|'-='|'*='|'/='|'%='|'&='|'|=') rhs=expression ';'      #opAndAssignmentStatement
    |   expression ';'          #functionCallStatement
    |   assembly #assemblyStatement
    |   assertion #assertionStatement
    ;

elseifStatement:
    'else' 'if' '(' conditional=expression ')' '{' statement '}';

elseStatement:
    'else' '{' statement '}';

number:
        INT
    | FLOAT
    ;

assembly:
    'asm' '(' STRING ')' ';'
    ;

assertion:
    'assert' '(' expression ')' ';'
    ;

// expressions should push a single value on to the stack (net +1, temp variables are fine)
expression:
        '(' type ')' expression                                             #castExpression // cast like (byte) getInteger()
    |   ID '(' exprList? ')'                                                #functionCallExpression  // func call like f(), f(x), f(1,2)
    |   ID '[' expression ']'                                               #arrayAccessExpression   // array index like a[i], a[i][j]
    |   '$' ID                                                              #addressOfVariableExpression     // push variable location
    |   '@' expression                                                      #valueAtVariableExpression     // push variable at (expression as location)
    |   '#' expression                                                      #lengthOfExpression     // return length of variable (op COUNT)
    |   '#' type                                                            #sizeOfExpression     // return sizeof(type)
    |   '-' expression                                                      #negateExpression   // unary minus
    |   '!' expression                                                      #notExpression  // boolean not
    |   lhs=expression ('%') rhs=expression                                 #moduloExpression
    |   lhs=expression op=('*'|'/') rhs=expression                          #multDivExpression
    |   lhs=expression op=('+'|'-') rhs=expression                          #addSubExpression
    |   lhs=expression op=('&'|'|'|'^'|'~') rhs=expression                  #bitwiseExpression
    |   lhs=expression op=('&&'|'||') rhs=expression                        #andOrExpression
    |   lhs=expression op=('<'|'<='|'>'|'>=') rhs=expression                #comparisonExpression     //  comparison
    |   lhs=expression op=('=='|'!=') rhs=expression                        #equalityExpression     // equality comparison (lowest priority op)
    |   ID                                                                  #variableReferenceExpression     // variable reference
    |   number                                                              #numberLiteralExpression
    |   booleanLiteral                                                      #booleanLiteralExpression
    |   STRING                                                              #stringLiteralExpression        // strings are byte arrays
    |   CHAR                                                                #charLiteralExpression
    |   '(' expression ')'                                                  #parenExpression
    | condition=expression '?' iftrue=expression ':' iffalse=expression     #ternaryExpression
    ;
exprList : expression (',' expression)* ;   // arg list

ID  :   LETTER (LETTER | [0-9])* ;
fragment
LETTER : [a-zA-Z] ;

//NUMBER: (INT | FLOAT) ; better as production rule

INT :   [0-9]+ ;
fragment HEXDIGIT : 'a'..'f' | 'A'..'F' | [0-9]; // todo implement
fragment EXPONENT : ('e' | 'E') ('+' | '-')? [0-9]+; // todo implement   implement ternary and asm();

FLOAT: (INT) '.' (INT)? (EXPONENT)? /*'f'?*/; // since there are no doubles just use . to indicate floats

STRING
    :   '"' StringCharSequence? '"'
    ;

CHAR
    : '\'' StringChar '\''  ;

fragment
StringCharSequence
    :   StringChar+
    ;
fragment
StringChar
    :   ~["\\\r\n]
//    |   EscapeSequence
    |   '\\\n'   // Added line
    |   '\\\r\n' // Added line
    ;

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT
    :   '//' .*? '\n' -> skip
    ;

ML_COMMENT
    : '/*' .*? '*/' -> skip
    ;