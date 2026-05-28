# Mapping from a Device Tree compatible string to the DTB (and optional
# overlays) that implement it.
#
# Syntax:
# FIT_DTB_COMPATIBLE[<compatible-encoded>] = "<dtb-stem>[ <overlay-stem>[ <overlay-stem>...]]"
#
# <compatible-encoded> is the DT compatible string with every comma replaced
# by an underscore (BitBake flag names cannot contain commas).  For example,
# "qcom,apq8016-sbc" is written as "qcom_apq8016-sbc".
#
# Rules
# -----
# - do_generate_qcom_fitimage silently skips any combo whose files are absent
#   from KERNEL_DEVICETREE, so entries that reference linux-qcom-only overlays
#   (el2, camx, staging, ifp-mezzanine) are safely ignored for linux-yocto builds.

# ---------- Direct mapping, no overlay ----------
FIT_DTB_COMPATIBLE[qcom_apq8016-sbc] = "apq8016-sbc"
FIT_DTB_COMPATIBLE[qcom_apq8064-ifc6410] = "qcom-apq8064-ifc6410"
FIT_DTB_COMPATIBLE[qcom_apq8064] = "qcom-apq8064-asus-nexus7-flo"
FIT_DTB_COMPATIBLE[qcom_apq8074-dragonboard] = "qcom-apq8074-dragonboard"
FIT_DTB_COMPATIBLE[qcom_apq8084-sbc] = "qcom-apq8084-ifc6540"
FIT_DTB_COMPATIBLE[qcom_apq8096-sbc] = "apq8096-db820c"
FIT_DTB_COMPATIBLE[qcom_glymur-crd] = "glymur-crd"
FIT_DTB_COMPATIBLE[qcom_kaanapali-mtp] = "kaanapali-mtp"
FIT_DTB_COMPATIBLE[qcom_msm8974] = "qcom-msm8974-lge-nexus5-hammerhead"
FIT_DTB_COMPATIBLE[qcom_purwa-evk] = "purwa-iot-evk"
FIT_DTB_COMPATIBLE[qcom_qcs404-evb-4000] = "qcs404-evb-4000"
FIT_DTB_COMPATIBLE[qcom_qrb2210-rb1] = "qrb2210-rb1"
FIT_DTB_COMPATIBLE[qcom_qrb4210-rb2] = "qrb4210-rb2"
FIT_DTB_COMPATIBLE[qcom_qrb5165-rb5] = "qrb5165-rb5"
FIT_DTB_COMPATIBLE[qcom_sdm845] = "sdm845-db845c"
FIT_DTB_COMPATIBLE[qcom_sm8450-hdk] = "sm8450-hdk"
FIT_DTB_COMPATIBLE[qcom_sm8750-mtp] = "sm8750-mtp"

# ---------- hamoa ----------
FIT_DTB_COMPATIBLE[qcom_hamoa-evk] = \
    "hamoa-iot-evk hamoa-iot-evk-camera-imx577"
FIT_DTB_COMPATIBLE[qcom_hamoa-evk-camx] = "hamoa-iot-evk hamoa-evk-camx"

# ---------- lemans ----------
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot] = \
    "lemans-evk lemans-evk-camera-csi1-imx577"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-staging] = \
    "lemans-evk lemans-evk-camera-csi1-imx577 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-el2kvm] = \
    "lemans-evk lemans-evk-camera-csi1-imx577 lemans-el2"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-el2kvm-staging] = \
    "lemans-evk lemans-evk-camera-csi1-imx577 lemans-el2 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-camx] = \
    "lemans-evk lemans-evk-camx"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-camx-staging] = \
    "lemans-evk lemans-evk-camx lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-camx-el2kvm] = \
    "lemans-evk lemans-evk-camx lemans-el2 lemans-camx-el2"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-camx-el2kvm-staging] = \
    "lemans-evk lemans-evk-camx lemans-el2 lemans-camx-el2 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-subtype1] = \
    "lemans-evk lemans-evk-ifp-mezzanine"
FIT_DTB_COMPATIBLE[qcom_qcs9075-iot-subtype1-staging] = \
    "lemans-evk lemans-evk-ifp-mezzanine lemans-staging lemans-evk-staging"

FIT_DTB_COMPATIBLE[qcom_qcs9100-qam] = "qcs9100-ride"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-staging] = \
    "qcs9100-ride lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-el2kvm] = \
    "qcs9100-ride lemans-el2"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-el2kvm-staging] = \
    "qcs9100-ride lemans-el2 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-camx] = \
    "qcs9100-ride sa8775p-ride-camx"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-camx-staging] = \
    "qcs9100-ride sa8775p-ride-camx lemans-staging"

FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-r2.0] = "qcs9100-ride-r3"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-r2.0-staging] = \
    "qcs9100-ride-r3 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-r2.0-el2kvm] = \
    "qcs9100-ride-r3 lemans-el2"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-r2.0-el2kvm-staging] = \
    "qcs9100-ride-r3 lemans-el2 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-r2.0-camx] = \
    "qcs9100-ride-r3 sa8775p-ride-camx"
FIT_DTB_COMPATIBLE[qcom_qcs9100-qam-r2.0-camx-staging] = \
    "qcs9100-ride-r3 sa8775p-ride-camx lemans-staging"

FIT_DTB_COMPATIBLE[qcom_sa8775p-qam] = "sa8775p-ride"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-staging] = \
    "sa8775p-ride lemans-staging"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-el2kvm] = \
    "sa8775p-ride lemans-el2"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-el2kvm-staging] = \
    "sa8775p-ride lemans-el2 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-camx] = \
    "sa8775p-ride sa8775p-ride-camx"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-camx-staging] = \
    "sa8775p-ride sa8775p-ride-camx lemans-staging"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-camx-el2kvm] = \
    "sa8775p-ride sa8775p-ride-camx lemans-el2 lemans-camx-el2"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-camx-el2kvm-staging] = \
    "sa8775p-ride sa8775p-ride-camx lemans-el2 lemans-camx-el2 lemans-staging"

FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0] = "sa8775p-ride-r3"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-staging] = \
    "sa8775p-ride-r3 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-el2kvm] = \
    "sa8775p-ride-r3 lemans-el2"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-el2kvm-staging] = \
    "sa8775p-ride-r3 lemans-el2 lemans-staging"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-camx] = \
    "sa8775p-ride-r3 sa8775p-ride-camx"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-camx-staging] = \
    "sa8775p-ride-r3 sa8775p-ride-camx lemans-staging"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-camx-el2kvm] = \
    "sa8775p-ride-r3 sa8775p-ride-camx lemans-el2 lemans-camx-el2"
FIT_DTB_COMPATIBLE[qcom_sa8775p-qam-r2.0-camx-el2kvm-staging] = \
    "sa8775p-ride-r3 sa8775p-ride-camx lemans-el2 lemans-camx-el2 lemans-staging"

# ---------- monaco ----------
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot] = \
    "monaco-evk monaco-evk-camera-imx577"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-staging] = \
    "monaco-evk monaco-evk-camera-imx577 monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-el2kvm] = \
    "monaco-evk monaco-evk-camera-imx577 monaco-el2"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-el2kvm-staging] = \
    "monaco-evk monaco-evk-camera-imx577 monaco-el2 monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-camx] = "monaco-evk monaco-evk-camx"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-camx-staging] = \
    "monaco-evk monaco-evk-camx monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-camx-el2kvm] = \
    "monaco-evk monaco-evk-camx monaco-el2 monaco-camx-el2"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-camx-el2kvm-staging] = \
    "monaco-evk monaco-evk-camx monaco-el2 monaco-camx-el2 monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-subtype3] = "monaco-evk monaco-evk-ifp-mezzanine"
FIT_DTB_COMPATIBLE[qcom_qcs8275-iot-subtype3-staging] = \
    "monaco-evk monaco-evk-ifp-mezzanine monaco-staging monaco-evk-staging"

FIT_DTB_COMPATIBLE[qcom_qcs8300-adp] = "qcs8300-ride"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-staging] = "qcs8300-ride monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-el2kvm] = "qcs8300-ride monaco-el2"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-el2kvm-staging] = \
    "qcs8300-ride monaco-el2 monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-camx] = "qcs8300-ride qcs8300-ride-camx"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-camx-staging] = \
    "qcs8300-ride qcs8300-ride-camx monaco-staging"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-camx-el2kvm] = \
    "qcs8300-ride qcs8300-ride-camx monaco-el2 monaco-camx-el2"
FIT_DTB_COMPATIBLE[qcom_qcs8300-adp-camx-el2kvm-staging] = \
    "qcs8300-ride qcs8300-ride-camx monaco-el2 monaco-camx-el2 monaco-staging"

# ---------- talos ----------
FIT_DTB_COMPATIBLE[qcom_qcs615-adp] = "qcs615-ride"
FIT_DTB_COMPATIBLE[qcom_qcs615-adp-staging] = \
    "qcs615-ride talos-staging"
FIT_DTB_COMPATIBLE[qcom_qcs615-adp-el2kvm] = \
    "qcs615-ride talos-el2"
FIT_DTB_COMPATIBLE[qcom_qcs615-adp-el2kvm-staging] = \
    "qcs615-ride talos-el2 talos-staging"

FIT_DTB_COMPATIBLE[qcom_qcs615-iot] = "talos-evk talos-evk-camera-imx577"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-staging] = \
    "talos-evk talos-evk-camera-imx577 talos-staging"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-el2kvm] = \
    "talos-evk talos-evk-camera-imx577 talos-el2"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-el2kvm-staging] = \
    "talos-evk talos-evk-camera-imx577 talos-el2 talos-staging"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-camx] = "talos-evk talos-evk-camx"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-camx-staging] = \
    "talos-evk talos-evk-camx talos-staging"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-camx-el2kvm] = \
    "talos-evk talos-evk-camx talos-el2"
FIT_DTB_COMPATIBLE[qcom_qcs615-iot-camx-el2kvm-staging] = \
    "talos-evk talos-evk-camx talos-el2 talos-staging"

FIT_DTB_COMPATIBLE[qcom_talos-evk-lvds-auo_g133han01] = \
    "talos-evk talos-evk-lvds-auo_g133han01"
FIT_DTB_COMPATIBLE[qcom_talos-evk-lvds-auo_g133han01-staging] = \
    "talos-evk talos-evk-lvds-auo_g133han01 talos-staging"
FIT_DTB_COMPATIBLE[qcom_talos-evk-lvds-auo_g133han01-el2kvm] = \
    "talos-evk talos-evk-lvds-auo_g133han01 talos-el2"
FIT_DTB_COMPATIBLE[qcom_talos-evk-lvds-auo_g133han01-el2kvm-staging] = \
    "talos-evk talos-evk-lvds-auo_g133han01 talos-el2 talos-staging"

# ---------- kodiak ----------
FIT_DTB_COMPATIBLE[qcom_qcm6490-idp] = "qcm6490-idp"
FIT_DTB_COMPATIBLE[qcom_qcm6490-idp-staging] = "qcm6490-idp kodiak-staging"
FIT_DTB_COMPATIBLE[qcom_qcm6490-idp-el2kvm] = "qcm6490-idp kodiak-el2"

FIT_DTB_COMPATIBLE[qcom_qcs5430-iot] = "qcs6490-rb3gen2"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot] = "qcs6490-rb3gen2"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-el2kvm] = \
    "qcs6490-rb3gen2 kodiak-el2"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-el2kvm] = \
    "qcs6490-rb3gen2 kodiak-el2"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-staging] = \
    "qcs6490-rb3gen2 kodiak-staging qcs6490-rb3gen2-staging"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-staging] = \
    "qcs6490-rb3gen2 kodiak-staging qcs6490-rb3gen2-staging"

FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype9] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-industrial-mezzanine"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype9] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-industrial-mezzanine"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype9-el2kvm] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-industrial-mezzanine kodiak-el2"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype9-el2kvm] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-industrial-mezzanine kodiak-el2"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype9-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-industrial-mezzanine kodiak-staging qcs6490-rb3gen2-industrial-mezzanine-staging"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype9-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-industrial-mezzanine kodiak-staging qcs6490-rb3gen2-industrial-mezzanine-staging"

FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype2] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype2] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype2-el2kvm] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine kodiak-el2"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype2-el2kvm] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine kodiak-el2"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype2-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine kodiak-staging"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype2-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine kodiak-staging"

FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-camx] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype2-camx] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-camx] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype2-camx] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-camx-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx kodiak-staging"
FIT_DTB_COMPATIBLE[qcom_qcs5430-iot-subtype2-camx-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx kodiak-staging"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-camx-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx kodiak-staging"
FIT_DTB_COMPATIBLE[qcom_qcs6490-iot-subtype2-camx-staging] = \
    "qcs6490-rb3gen2 qcs6490-rb3gen2-vision-mezzanine-camx kodiak-staging"
