require linux-vuplus-2.6.18.inc

PR = "r12"

SRC_URI += "\
	file://vusolo_defconfig \
	file://linux-vusolo_nand4.patch;patch=1;pnum=0 \
	file://linux-vusolo_info.patch;patch=1;pnum=0 \
	file://linux-vusolo_setup.patch;patch=1;pnum=0 \
	file://linux-vusolo_romblock.patch;patch=1;pnum=0 \
	file://linux-vusolo_serial.patch;patch=1;pnum=0 \
	"
