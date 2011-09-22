require linux-vuplus-2.6.18.inc

PR = "r15"

SRC_URI += "\
	file://vuultimo_defconfig \
	file://linux_vuultimo_nand2.patch;patch=1;pnum=1 \
        file://linux_vuultimo_proc.patch;patch=1;pnum=0 \
        file://linux_vuultimo_serial.patch;patch=1;pnum=0 \
	"

