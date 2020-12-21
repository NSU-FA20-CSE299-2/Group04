from django.db import models


class student(models.Model):
    firstname = models.CharField(max_length=100, default='SOME STRING')
    lastname = models.CharField(max_length=100, default='SOME STRING')
    student_id = models.IntegerField(default=0)
    enrolled_in = models.IntegerField(default=0)
    curriculum_name = models.CharField(max_length=100, default='SOME STRING')
    entry_item = models.CharField(max_length=100, default='SOME STRING')
    test_pass_number = models.IntegerField(default=0)
    current_status = models.CharField(max_length=50, default='SOME STRING')
    current_cgpa = models.FloatField(default=0)
    credits_passed = models.FloatField(default=0)
    probation = models.IntegerField(default=0)
    major_1 = models.IntegerField(default=0)
    major_2 = models.IntegerField(default=0)
    cell_phone = models.IntegerField(default=0)
    personal_email = models.CharField(max_length=100, default='SOME STRING')
    date_of_birth = models.DateTimeField
    sex = models.CharField(max_length=10, default='SOME STRING')
    citizenship = models.CharField(max_length=20, default='SOME STRING')
    blood_group = models.CharField(max_length=5, default='SOME STRING')
    marital_status = models.CharField(max_length=10, default='SOME STRING')
    mailing_address = models.CharField(max_length=200, default='SOME STRING')
    telephone = models.IntegerField(default=0)
    fathers_name = models.CharField(max_length=50, default='SOME STRING')
    mothers_name = models.CharField(max_length=50, default='SOME STRING')
    guardian_name = models.CharField(max_length=50, default='SOME STRING')
    parent_address = models.CharField(max_length=200, default='SOME STRING')
    parent_phone = models.IntegerField(default=0)

    def __str__(self):
        return self.firstname
