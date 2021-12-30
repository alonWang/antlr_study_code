lexer grammar CommonLexerRules;

ID: [a-zA-Z_] ;
INT: [0-9]+ ;
NEWLINE: '\r'?'\n' ;
WS: [ \t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;