from rest_framework import serializers
from rest_framework import students


class studentsSerializer(serializers.ModelSerializer):
    class Meta:
        model = students
        fields = '__all__'
