package lectures7

//Files and directories

//File - is a string of bytes saved on a disk or other physically persistent form.
//Files and directories can be represented by objects of the File type.

//from the current directory
f1 = new File(' text.txt')
def f2 = new File(' text.txt')
File f3 = new File('text.txt')


f4 = new File('c:\\src\\Prog.groovy')
f5 = new File('c:/src/Prog.groovy')

//From the sub subdirectory of the current directory
f3 = new File('sub/Some.txt')

//From the above directory of the current directory
f4 = new File('../Some.txt')


cdir = new File('.')
someDir = new File('c:/temp')