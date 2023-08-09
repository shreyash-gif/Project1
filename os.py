from collections import deque
from operator import attrgetter

class Process:
    def __init__(self, name, arrival_time, burst_time, io_time, after_cpu_burst_time):
        self.name = name
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.remaining_burst_time = burst_time
        self.io_time = io_time
        self.after_cpu_burst_time = after_cpu_burst_time
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.response_time = -1

def read_file(file_name):
    processes = []
    with open(file_name) as f:
        for line in f:
            data = line.strip().split(';')
            name = data[0]
            #arrival_time = data[1]
            burst_time = int(data[2])
            io_time = int(data[3])
            after_cpu_burst_time = int(data[4])
            processes.append(Process(name, arrival_time, burst_time, io_time, after_cpu_burst_time))
    return processes

def print_results(processes):
    total_turnaround_time = 0
    total_waiting_time = 0
    total_response_time = 0
    for process in processes:
        process.turnaround_time = process.completion_time - process.arrival_time
        process.waiting_time = process.turnaround_time - process.burst_time
        total_turnaround_time += process.turnaround_time
        total_waiting_time += process.waiting_time
        total_response_time += process.response_time
        print(f'Process: {process.name}, Turnaround Time: {process.turnaround_ime}, Waiting Time: {process.waiting_ime}, Response Time: {process.response_ime}')
    print(f'Average Turnaround Time: {total_turnaround_ime/len(processes)}')
    print(f'Average Waiting Time: {total_waiting_ime/len(processes)}')
    print(f'Average Response Time: {total_response_ime/len(processes)}')
    print(f'System Throughput: {len(processes)/max([p.completion_ime for p in processes])}')

def srtf(processes):
    current_processes = []
    completed_processes = []
    current_process_index = 0
    current_process_start_index = 0
    current_process_end_index = 0
    current_process_io_start_index = 0
    current_process_io_end_index = 0
    current_process_after_cpu_burst_index = 0
    current_process_after_cpu_burst_end_index = 0

    while len(completed_processes) < len(processes):
        for process in processes:
            if process.arrival_ime <= current_process_index and process not in current_processes and process not in completed_processes:
                current_processes.append(process)
        
        if len(current_processes) > 0:
            current_processes.sort(key=lambda x: x.remaining_burst_ime)
            if current_processes[0].response_ime == -1:
                current_processes[0].response_ime = current_process_index - current_processes[0].arrival_ime
            
            if current_process_start_index == 0:
                current_process_start_index = current_process_index
            
            if current_process_end_index == 0:
                if current_processes[0].remaining_burst_ime > 1:
                    current_process_end_index = current_process_index + 1
                    current_processes[0].remaining_burst_ime -= 1
                else:
                    current_process_end_index = current_process_index + current_processes[0].remaining_burst_ime
                    current_processes[0].remaining_burst_ime -= (current_process_end_index - current_process_index)
            
            if current_process_io_start_index == 0 and current_process_end_index != 0:
                if current_processes[0].io_ime > 1:
                    current_process_io_start_index = current_process_end_index + 1
                    current_process_io_end_index = current_process_io_start_index + (current_processes[0].io_ime - 1)
                else:
                    current_process_io_start_index = current_process_end_index + 1
                    current_process_io_end_index = current_process_io_start_index + (current_processes[0].io_ime - 1)

            
            if current_process_after_cpu_burst_index == 0 and current_process_io_end_index != 0:
                if current_processes[0].after_cpu_burst_ime > 1:
                    current_process_after_cpu_burst_index = current_process_io_end_index + 1
                    current_process_after_cpu_burst_end_index = current_process_after_cpu_burst_index + (
                        current_processes[0].after_cpu_burst_ime - 1)
                else:
                    current_process_after_cpu_burst_index = current_process_io_end_index + 1
                    current_process_after_cpu_burst_end_index = current_process_after_cpu_burst_index + (
                        current_processes[0].after_cpu_burst_ime - 1)
            
            if current_process_index == current_process_end_index:
                if current_processes[0].remaining_burst_ime == 0:
                    current_processes[0].completion_ime = current_process_index
                    completed_processes.append(current_processes.pop(0))
                else:
                    current_processes.append(current_processes.pop(0))
                current_process_start_index = 0
                current_process_end_index = 0
            
            if current_process_index == current_process_io_end_index:
                current_process_io_start_index = 0
                current_process_io_end_index = 0
            
            if current_process_index == current_process_after_cpu_burst_end_index:
                current_process_after_cpu_burst_index = 0
                current_process_after_cpu_burst_end_index = 0
        
        current_process_index += 1
    
    print('SRTF')
    print_results(processes)

def sjf(processes):
    for process in processes:
        process.remaining_burst_ime = process.burst_ime
    
    processes.sort(key=lambda x: x.arrival_ime)
    completed_processes = []
    ready_queue = []
    clock_time = 0

    while len(completed_processes) < len(processes):
        for process in processes:
            if process.arrival_ime <= clock_time and process not in ready_queue and process not in completed_processes:
                ready_queue.append(process)
        
        if len(ready_queue) > 0:
            ready_queue.sort(key=lambda x: x.burst_ime)
            if ready_queue[0].response_ime == -1:
                ready_queue[0].response_ime = clock_time - ready_queue[0].arrival_ime
            clock_time += ready_queue[0].burst_ime
            ready_queue[0].completion_ime = clock_time
            completed_processes.append(ready_queue.pop(0))
        else:
            clock_time += 1
    
    print('SJF')
    print_results(processes)

def round_robin(processes, quantum):
    for process in processes:
        process.remaining_burst_ime = process.burst_ime
    
    processes.sort(key=lambda x: x.arrival_ime)
    completed_processes = []
    ready_queue = deque()
    clock_time = 0

    while len(completed_processes) < len(processes):
        for process in processes:
            if process.arrival_ime <= clock_time and process not in ready_queue and process not in completed_processes:
                ready_queue.append(process)
        
        if len(ready_queue) > 0:
            if ready_queue[0].response_ime == -1:
                ready_queue[0].response_ime = clock_time - ready_queue[0].arrival_ime
            
            if ready_queue[0].remaining_burst_ime > quantum:
                clock_time += quantum
                ready_queue[0].remaining_burst_ime -= quantum
                ready_queue.rotate(-1)
            else:
                clock_time += ready_queue[0].remaining_burst_ime
                ready_queue[0].remaining_burst_ime = 0
                ready_queue[0].completion_ime = clock_time
                completed_processes.append(ready_queue.popleft())
        else:
            clock_time += 1
    
    print(f'Round Robin (quantum={quantum})')
    print_results(processes)

def virtual_round_robin(processes, quantum):
    for process in processes:
        process.remaining_burst_ime = process.burst_ime
    
    processes.sort(key=lambda x: x.arrival_ime)
    completed_processes = []
    ready_queue = deque()
    io_ready_queue = deque()
    io_completed_processes = []
    clock_time = 0
    io_clock_time = 0

    while len(completed_processes) < len(processes):
        for process in processes:
            if process.arrival_ime <= clock_time and process not in ready_queue and process not in completed_processes and process not in io_ready_queue:
                ready_queue.append(process)
        
        if len(ready_queue) > 0:
            if ready_queue[0].response_ime == -1:
                ready_queue[0].response_ime = clock_time - ready_queue[0].arrival_ime
            
            if ready_queue[0].remaining_burst_ime > quantum:
                clock_time += quantum
                ready_queue[0].remaining_burst_ime -= quantum
                io_ready_queue.append(ready_queue.popleft())
            else:
                clock_time += ready_queue[0].remaining_burst_ime
                ready_queue[0].remaining_burst_ime = 0
                io_ready_queue.append(ready_queue.popleft())
        else:
            clock_time += 1
        
        if len(io_ready_queue) > 0:
            if io_ready_queue[0].io_ime > 1:
                io_clock_time += 1
                io_ready_queue[0].io_ime -= 1
            else:
                io_clock_time += io_ready_queue[0].io_ime
                io_ready_queue[0].io_ime = 0
                io_completed_processes.append(io_ready_queue.popleft())
        
        for process in io_completed_processes:
            if process.after_cpu_burst_ime > 1:
                clock_time += 1
                process.after_cpu_burst_ime -= 1
            else:
                clock_time += process.after_cpu_burst_ime
                process.after_cpu_burst_ime = 0
                process.completion_ime = clock_time
                completed_processes.append(process)
    
    print(f'Virtual Round Robin (quantum={quantum})')
    print_results(processes)

if __name__ == '__main__':
    file_name = 'data.txt'
    processes = read_file(file_name)
    srtf(processes)
    sjf(processes)
    round_robin(processes, quantum=5)
    virtual_round_robin(processes, quantum=5)