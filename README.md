# Linear-Equation-Solver
takes in a file, which contains the number of variables, the number of equations, and a matrix. Then it uses Gauss Jordan elimination to solve it, and output the variables in a designated output file.

"java Main -in in.txt -out out.txt" where in.txt is the file containing the matrix, and out.txt is where it will put the answers.

input file should look like this:

3 4

0 1 2 9

0 1 3 1

1 0 6 0

2 0 2 0

Where the first number is the number of variables, the second number is the number of equations, and below that is the matrix, each number separated by a space. 
