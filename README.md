How to use this tool should be pretty self explanatory, if you dont know how to edit a string then I have no idea why you would be looking at stack operations.

Just go into your editor of choice, 
open the .java file, 
change the expressions with the expressions you want to use,
change the operations with the stack operations list you want to use,
select the function you want (just copy paste it from the comment in main into main jump to line 15 for information),
then just compile and run






runTest(operations, expressions);
tests if the stack operations are valid on the expressions given

runReversedExpressionTest(operations, expressions);
tests if the stack operations are valid on the expressions if the expressions are reversed (i.e when converting from infix to prefix)


runThroughStack(operations, expressions);
goes through the stack operations step by step

runThroughReversedExpressionStack(operations, expressions);
goes through the stack operations step by step when the expressions are reversed
