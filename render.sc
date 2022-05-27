(
~a = [[512,384,512,384,320,512,384,448,512],[512,384,512,384,320,512,384,448,512],[512,384,512,384,320,512,384,448,512],[512,384,512,384,320,512,384,448,512],[512,384,512,384,320,512,384,448,512],[512,384,512,384,320,512,384,448,512],[512,384,512,384,320,512,384,448,512]];
	
~b = [[512,384,512,384,320,512,384,448,512],[512.3273663849985,384.34177349749416,511.80347475467096,383.28797188478865,319.18164049054224,513.0088138744911,383.87180327999397,446.9708686612541,511.203225353056],[511.6894805855601,384.6285371898499,511.1358121963913,384.25793270730526,318.9112618711705,512.9380870167533,384.30943288025134,448.7767707300156,512.4172667190795],[512.9726270174339,383.251106869382,511.15982668788024,382.9472449482555,320.885136496823,510.871434305259,383.4977709861119,448.9065824012989,512.6155195631432],[511.85008686833044,383.03290125088546,512.2173926071356,383.2172121664536,321.0163610513531,512.6041843337545,384.4039762793576,447.4256135543901,512.0624863613702],[511.99971597003656,383.92181322021526,512.5873512779241,383.10441668686536,319.8465768212346,513.1975782468626,383.1240154635315,449.17929503735763,510.98695310747695],[511.76254743922925,384.36073660107087,512.288997941153,383.3287373409603,319.23799695643913,512.4529813333459,384.76862668338646,448.60982028444135,512.0742424075278]];
		
~c = [[512,384,512,384,320,512,384,448,512],[512.3,382.8,509.6,383.925,320.075,512.3,383.925,447.4,512.15],[512.3,386.4,510.8,386.4,321.2,513.2,385.2,445.6,511.7],[511.7,386.4,512.075,383.85,320.3,511.85,383.4,447.925,512.075],[509.6,383.4,509.6,382.8,317.6,511.925,386.4,447.4,512.3],[511.85,384.15,512.6,384.3,319.7,512.3,383.925,450.4,512.15],[512.15,386.4,512.6,386.4,319.4,511.7,383.7,448.075,512.15]];

SynthDef(\sin, {|freq, amp = 0.1|
	var sig = SinOsc.ar(freq, mul: Env.perc.ar);
	
	Out.ar([0, 1], sig * amp);
	DetectSilence.ar(sig, doneAction: 2)
}).add;

)

(

// do it for each of ~a, ~b, and ~c
s.record;
~a.do({|freqs|
	freqs.postln;
Pbind(
	\instrument, \sin,
		\freq, Pseq(freqs, inf)
	).play;
});
)

