def propertyMissing(propName) { propName }
def resetVariables() {
    moveDir = ''
    jumpHow = ''
    jumpWhere = ''
}

resetVariables()

def move(dir) {
    moveDir = dir
    this
}

def jump(how, where) {
    jumpHow = how
    jumpWhere = where
    this
}

def turn(dir) {
    if (moveDir) {
        println "moving $moveDir"
    } else {
        println "jumping $jumpHow and $jumpWhere"
    }
    println "turning $dir"
    resetVariables()
}

def and(ignore) {
    this
}

move forward and then turn left
//moving forward
//turning left

jump fast, forward and then turn right
//jumping fast and forward
//turning right
