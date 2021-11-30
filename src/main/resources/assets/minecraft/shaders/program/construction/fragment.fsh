#version 120

uniform sampler2D sampler;

varying vec2 uv;
varying float height;

uniform float cutoff;
uniform float insertedAlpha;
uniform float machineHeight;

void main() {
    vec3 topColor = vec3(1.0, 0.890196078, 0.57254902);
    vec3 bottomColor = vec3(0.988235294, 0.509803922, 0.22745098);

    vec4 texture = texture2D(sampler, uv);
    vec3 mixColor;
    float alpha = 1;
    if (texture.w == 0) {
        alpha=0;
    } else {
        if (height<cutoff) {
            mixColor = mix(bottomColor, topColor, clamp((height + machineHeight - cutoff)/machineHeight, 0, 1));
        } else {
            float diff = height-cutoff;
            if (diff < 0.4) {
                mixColor = mix(topColor, vec3(1), (diff - 0.15)/0.1);
            } else {
                texture = vec4(0);
                alpha = 0.0;
            }
        }
    }
    gl_FragColor = mix(texture, vec4(mixColor, alpha), insertedAlpha);
}
