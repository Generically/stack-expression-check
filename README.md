<h1>README</h1>
How to use this tool should be pretty self explanatory, if you dont know how to edit a string then I have no idea why you would be looking at stack operations.

<br><br>

Just go into your editor of choice, \
open the .java file, \
change the expressions with the expressions you want to use,\
change the operations with the stack operations list you want to use,\
select the function you want (just copy paste it from the comment in main into main),\
then just compile and run

<br><br>

<h2>Function TLDR</h2>

``` 
runTest(operations, expressions);
```
>tests if the stack operations are valid on the expressions given

<br><br>

```
runReversedExpressionTest(operations, expressions);
```
>tests if the stack operations are valid on the expressions if the expressions are reversed (i.e when converting from infix to prefix)

<br><br>

```
runThroughStack(operations, expressions);
```
>goes through the stack operations step by step

<br><br>

```
runThroughReversedExpressionStack(operations, expressions);
```
>goes through the stack operations step by step when the expressions are reversed
