@echo off
setlocal enabledelayedexpansion

REM Move from .temp to parent dir
cd ..

REM Move from parent dir to cat2 dir 
cd cat2

REM Removing old output if it exists
if exist output.txt del output.txt

for %%f in (*.java) do (
    echo ------ %%f ------ >> output.txt
    type "%%f" >> output.txt
    echo. >> output.txt
)

echo All files have been concatenated into output.txt (inside cat2)
pause
