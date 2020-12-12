from django.db import models


class students(models.Model):
    firstname = models.CharField(max_length=100)
    lastname = models.CharField(max_length=100)
    student_id = models.IntegerField()

    def __str__(self):
        return self.firstname