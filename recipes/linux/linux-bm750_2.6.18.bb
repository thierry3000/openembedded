require linux-vuplus-2.6.18.inc

PR = "r9"

SRC_URI += "\
	file://bm750_defconfig \
	file://linux_bm750_nand.patch;patch=1;pnum=0 \
	file://linux_bm750_proc.patch;patch=1;pnum=0 \
	file://linux_bm750_serial.patch;patch=1;pnum=0 \
	file://linux_bm750_setup.patch;patch=1;pnum=0 \
	"
