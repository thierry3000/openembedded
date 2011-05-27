require linux-vuplus-2.6.18.inc

PR = "r13"

SRC_URI += "\
	file://vuuno_defconfig \
	file://linux_vuuno_nand2.patch;patch=1;pnum=1 \
        file://linux_vuuno_proc.patch;patch=1;pnum=0 \
        file://linux_vuuno_serial.patch;patch=1;pnum=0 \
	"

