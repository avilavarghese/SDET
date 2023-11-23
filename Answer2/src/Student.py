class Student:
    def __init__(self, name, grade, age):
        self.name = name
        self.grade = grade
        self.age = age

    def display(self):
        print("Name: " + self.name)
        print("Grade: " + str(self.grade))
        print("Age: " + str(self.age))

class School(Student):
    def schoolStudentDisplay(self):
        self.display()

studentDetails = Student("Vijay", 12, 18)
print("Student Details:")
studentDetails.display()
print()

school_studentDetails = School("Leo",10,16)
print("School Student Details:")
school_studentDetails. schoolStudentDisplay()