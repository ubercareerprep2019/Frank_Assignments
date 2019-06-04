def solve_hanoi(n, start, goal, temp):
    """Prints out the instructions for moving n disks (ordered
    smallest to largest, going down) from the start to the 
    goal, using the temp, as needed.

    Preconditions: 
    start, goal, and temp are strings
    n is an integer"""
    #this is the base case
    if n == 1:
        # it's easy to move just 1 disk!
        print("move from " + start + " to " + goal)
        
    else:
    
        # first move the top n-1 disks temporarily to "temp" then move the
        # largest disk to the target peg. Then move the remaining n-1
        # disks back on top of thh largest @ target.

        # temporarily move all but the last disk to the "other peg"
        solve_hanoi(n-1, start, temp, goal)
        
        # move the last disk to the target peg 
        print("move from " + start + " to " + goal)

        # now move all but the last disk to the target peg
        solve_hanoi(n-1, temp, goal, start)


n_disks = int(input("How many disks are on your tower? "))
print("Do this, my friend,: ")

solve_hanoi(n_disks, "left", "right", "middle")
