# Linear-Equation-Solver
takes in a file, which contains the number of equations, and a matrix. Then it uses Gauss Jordan elimination to solve it, and output the variables in a designated output file.

"java Main -in in.txt -out out.txt" where in.txt is the file containing the matrix, and out.txt is where it will put the answers.

input file should look like this:
3
1 1 2 9

2 4 -3 1

3 6 -5 0

Where the first number is the number of equations, and below that is the matrix, each number separated by a space. 
