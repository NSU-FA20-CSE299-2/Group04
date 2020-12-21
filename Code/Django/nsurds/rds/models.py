from django.db import models


class student(models.Model):
    firstname = models.CharField(max_length=100)
    lastname = models.CharField(max_length=100)
    student_id = models.IntegerField()
    enrolled_in = models.IntegerField()
    curriculum_name = models.CharField(max_length=100)
    entry_item = models.CharField(max_length=100)
    test_pass_number = models.IntegerField()
    current_status = models.CharField(max_length=50)
    current_cgpa = models.FloatField()
    credits_passed = models.FloatField()
    probation = models.IntegerField()
    major_1 = models.IntegerField()
    major_2 = models.IntegerField()
    cell_phone = models.IntegerField()
    personal_email = models.CharField(max_length=100)
    date_of_birth = models.DateTimeField
    sex = models.CharField(max_length=10)
    citizenship = models.CharField(max_length=20)
    blood_group = models.CharField(max_length=5)
    marital_status = models.CharField(max_length=10)
    mailing_address = models.CharField(max_length=200)
    telephone = models.IntegerField()
    fathers_name = models.CharField(max_length=50)
    mothers_name = models.CharField(max_length=50)
    guardian_name = models.CharField(max_length=50)
    parent_address = models.CharField(max_length=200)
    parent_phone = models.IntegerField()

    def __str__(self):
        return self.firstname
