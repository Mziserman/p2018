class Offer < ActiveRecord::Base
	validates :title, length: (minimum: 2, maximum: 12, too_long: "yololo", too_short: "y")

end
