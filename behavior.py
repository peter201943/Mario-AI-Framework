

# A Test in Dynamic Design
# (In Python because Java hurts my head)


class StatusCode():
    """Enumerate the Task Messages"""
    
    def __init__(self):
        """Set the Values"""
        self.win = 0
        self.fail = 1
        self.running = 2

    def Fail(self, other):
        """Task has Failed Check"""
        return other == self.fail

    def Running(self, other):
        """Task still Working Check"""
        return other == self.running

    def Win(self, other):
        """Task has Won Check"""
        return other == self.win

    def Verbose(self, status):
        """Pretty Print Task Messages"""
        if self.Fail(status):
            return "fail"
        elif self.Win(status):
            return "win"
        elif self.Running(status):
            return "running"
        else:
            return "unknown"


class Task():
    """Performs a Computation every Cycle"""

    def __init__(self, name="noNameTask"):
        """Calls Reset"""
        self.name = name
        self.statuscode = StatusCode()
        self.Reset()

    def Run(self):
        """The Computation"""
        print("4: Task")
        self.status = self.statuscode.running
        self.clock += 1
        self.log += "Run " + str(self.clock) + ", " + self.__str__() + "\n"
        return self.status

    def __str__(self):
        """Gather Debug Info together"""
        return self.name + ": "  + "None " + " status: " + self.statuscode.Verbose(self.status)
        
    def Log(self):
        """Debug the Progress of the Task"""
        return self.log

    def Reset(self):
        """Resets the Task"""
        self.status = self.statuscode.running
        self.clock = 0
        self.log = self.name + "\n"

    def Name(self):
        return self.name


class Find(Task):
    """Finds Things every Cycle"""

    def __init__(self, newTargets, newTarget, name="noNameFind"):
        """Calls Reset"""
        self.name = name
        self.statuscode = StatusCode()
        self.Reset(newTargets, newTarget)

    def Run(self):
        """The Computation"""
        print("4: FindTask")
        self.clock += 1
        if (len(self.targets) > 0):
            if (self.targets[0] == self.target):
                self.found.append(self.targets[0])
            self.targets.pop(0)
            self.status = self.statuscode.running
        elif (len(self.found) > 0):
            self.status = self.statuscode.win
        else:
            self.status = self.statuscode.fail
        self.log += "Run " + str(self.clock) + ", " + self.__str__() + "\n"
        return self.status

    def Found(self):
        """The Results of the Compuation"""
        return str(self.found)

    def Targets(self):
        """Remaining Data to Compute"""
        return str(self.targets)

    def __str__(self):
        """Gather Debug Info together"""
        return self.name + ": " + str(self.target) + " in " + str(self.Targets()) + " has found " + str(self.Found()) + " status: " + self.statuscode.Verbose(self.status)

    def Log(self):
        """Debug the Progress of the Task"""
        return self.log

    def Reset(self, newTargets, newTarget):
        """Resets the Task"""
        self.found = []
        self.targets = newTargets
        self.target = newTarget
        self.status = self.statuscode.running
        self.clock = 0
        self.log = self.name + "\n"

    def Name(self):
        return self.name


class Container(Task):
    """Finds Children every Cycle"""

    def __init__(self, name="noNameContainer"):
        """Calls Reset"""
        self.name = name
        self.statuscode = StatusCode()
        self.Reset()

    def Run(self):
        """The Computation"""
        print("4: ContainerTask")
        self.clock += 1
        self.log += "Run " + str(self.clock) + ", " + self.__str__() + "\n"
        return self.status

    def __str__(self):
        """Gather Debug Info together"""
        return self.name + ": " +  " children: " + str(self.childnames) +  " status: " + self.statuscode.Verbose(self.status)

    def Log(self):
        """Debug the Progress of the Task"""
        recursiveLog = ""
        for child in self.children:
            recursiveLog += child.Log() + "\n\n"
        return self.log + "\n\n" + recursiveLog

    def Reset(self):
        """Resets the Task"""
        self.status = self.statuscode.running
        self.clock = 0
        self.children = []
        self.childnames = []
        self.log = self.name + "\n"

    def Children(self):
        """Access the Child Tasks"""
        return self.children

    def Add(self, task):
        self.children.append(task)
        self.childnames.append(task.Name())

    def Remove(self, task):
        if task in self.children:
            self.children.remove(task)
            self.childnames.remove(task.Name())

    def Name(self):
        return self.name


class Action(Task):
    """Performs an Effect every Cycle"""

    def __init__(self, name="noNameAction"):
        """Calls Reset"""
        self.name = name
        self.statuscode = StatusCode()
        self.Reset()

    def Run(self):
        """The Computation"""
        print("4: Action")
        self.status = self.statuscode.running
        self.clock += 1
        print("This is an Action!")
        self.status = self.statuscode.running
        self.log += "Run " + str(self.clock) + ", " + self.__str__() + "\n"
        return self.status

    def __str__(self):
        """Gather Debug Info together"""
        return self.name + ": "  + "None " + " status: " + self.statuscode.Verbose(self.status)

    def Log(self):
        """Debug the Progress of the Task"""
        return self.log

    def Reset(self):
        """Resets the Task"""
        self.status = self.statuscode.running
        self.clock = 0
        self.log = self.name + "\n"

    def Name(self):
        return self.name


class Parallel(Container):
    """Finds Children every Cycle"""

    def __init__(self, name="noNameParallel"):
        """Calls Reset"""
        self.name = name
        self.statuscode = StatusCode()
        self.Reset()

    def Run(self):
        """The Computation"""
        print("4: ParallelTask")
        self.clock += 1
        for child in self.children:
            child.Run()
        self.log += "Run " + str(self.clock) + ", " + self.__str__() + "\n"
        return self.status

    def __str__(self):
        """Gather Debug Info together"""
        return self.name + ": " +  " children: " + str(self.childnames) +  " status: " + self.statuscode.Verbose(self.status)

    def Log(self):
        """Debug the Progress of the Task"""
        recursiveLog = ""
        for child in self.children:
            recursiveLog += child.Log() + "\n\n"
        return self.log + "\n\n" + recursiveLog

    def Reset(self):
        """Resets the Task"""
        self.status = self.statuscode.running
        self.clock = 0
        self.children = []
        self.childnames = []
        self.log = self.name + "\n"

    def Children(self):
        """Access the Child Tasks"""
        return self.children

    def Add(self, task):
        self.children.append(task)
        self.childnames.append(task.Name())

    def Remove(self, task):
        if task in self.children:
            self.children.remove(task)
            self.childnames.remove(task.Name())

    def Name(self):
        return self.name





def Game(tasks, clock):
    """Runs the Tasks within the confines of an Environment"""
    print("\n3: game (" + str(clock) + ")")
    for task in tasks:
        task.Run()
    if (clock < 10):
        Game(tasks, (clock + 1))
    else:
        print("\n5: Results:")
        for task in tasks:
            print("6: " + task.Log())


def Setup():
    """Sets the Game Up"""
    print("2: setup")
    tasks = []

    # 0: Empty Task
    myTask = Task("0: Empty Task")
    tasks.append(myTask)

    # 1: Successful Condition Task
    myFind = Find(['a','b','a','a','b','b','b','b','a'], 'a', "1: Successful Condition Task")
    tasks.append(myFind)

    # 2: Failure Condition Task
    myFind2 = Find(['b','b','b','b','b'], 'a', "2: Failure Condition Task")
    tasks.append(myFind2)

    # 3: Container of Pointers
    myContainer = Container("3: Container of Pointers")
    myContainer.Add(myFind)
    myContainer.Add(myFind2)
    tasks.append(myContainer)

    # 4: Container of Uniques
    myContainer2 = Container("4: Container of Uniques")
    myContainer2.Add(Find([1,2,3],1))
    myContainer2.Add(Find([1,2,3],0))
    tasks.append(myContainer2)

    # 5: Parallel of Uniques
    myParallel = Parallel("5: Parallel of Uniques")
    myParallel.Add(Find([1,2,3],1, "aFind"))
    myParallel.Add(Find([1,2,3],0, "anotherFind"))
    tasks.append(myParallel)

    # 6: Empty Action
    myAction = Action("6: Empty Action")
    tasks.append(myAction)

    return tasks


def main():
    """Entry Point to Program"""
    print("1: main")
    Game(Setup(), 0)


if (__name__ == "__main__"):
    print("0: program")
    main()

