import csv

file_route = "lagos_arg.csv"

def my_function(data, *args):
    sub_set = filter(lambda x: x[1] in args and x[2] >= 50, data)

    my_data = {}
    for elem in sub_set:
        if elem[1] in my_data.keys():
            my_data[elem[1]].append(int(elem[2]))
        else:
            my_data[elem[1]] = [int(elem[2])]

    for elem in my_data:
        my_data[elem] = max(my_data[elem])

    return my_data

with open(file_route, "r") as data_set:
    reader = csv.reader(data_set)
    header, data = next(reader), list(reader)

result = my_function(data, "Chubut", "Río Negro")

print(result)
