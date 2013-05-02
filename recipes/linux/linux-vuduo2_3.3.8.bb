require linux-vuplus-3.3.8.inc


SRC_URI += "file://remove_genet1.patch;patch=1;pnum=1 \
        file://nand_base.patch;patch=1;pnum=1 \
	"

PR = "r0"
