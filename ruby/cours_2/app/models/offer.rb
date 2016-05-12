class Offer < ActiveRecord::Base

	# validates :title, presence: true, uniqueness: true, length: ( maximum: 140, message: "too long for a tweet")

	validates_presence_of :title
	validates_uniqueness_of :title
	validates_length_of :title, maximum: 140, message: "too long for a tweet"

	validates_numericality_of :price

	def published
		self.published_at != nil
	end

	def published=(val)
		if val == "1"
			self.published_at = Time.zone.now
		else
			self.published_at = nil
		end
	end

end
