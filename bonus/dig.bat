-- Dig to autohack an NPC and get you a new window with a root shell
---- Clip 5hell path
glosure -e " (program_path) " | clipb
---- Brute root shell and clip it
cerebrum || brutus | clipa
---- Add the clipped root shell to the undercover buffer
undercover -b @a
---- Open new window with 5hell run as root and notify if there is an administrator online
nt " @b mimi " @a
---- Clips cleanup
clipa -n
clipb -n
clipc -n
